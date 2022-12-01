package com.roles.permission.config;

import java.util.List;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
@Service
public class UserDetailsServiceDelegator implements UserDetailsService {

	private List<AuthenticationManagerBuilder> delegateBuilders;

	private UserDetailsService delegate;

	private final Object delegateMonitor = new Object();

	UserDetailsServiceDelegator(List<AuthenticationManagerBuilder> delegateBuilders) {
		Assert.isTrue(!delegateBuilders.contains(null),
				() -> "delegateBuilders cannot contain null values. Got " + delegateBuilders);
		this.delegateBuilders = delegateBuilders;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (this.delegate != null) {
			return this.delegate.loadUserByUsername(username);
		}
		synchronized (this.delegateMonitor) {
			if (this.delegate == null) {
				for (AuthenticationManagerBuilder delegateBuilder : this.delegateBuilders) {
					this.delegate = delegateBuilder.getDefaultUserDetailsService();
					if (this.delegate != null) {
						break;
					}
				}
				if (this.delegate == null) {
					throw new IllegalStateException("UserDetailsService is required.");
				}
				this.delegateBuilders = null;
			}
		}
		return this.delegate.loadUserByUsername(username);
	}

}