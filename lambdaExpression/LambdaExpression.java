package corejava.lambdaExpression;

/* Lambda is Anonymous Function/Method (No Name, No Modifier, No Return Type) */

public class LambdaExpression implements LambdaInterface {
	@Override
	public void tejas() {
		System.out.println("Hello, I am Lambda Interface");
	}

	public static void main(String[] args) {
		System.out.println("Hi, I Am Main Method");

		// LambdaInterface	 // Normal
		LambdaInterface li = new LambdaExpression();
		li.tejas();

		// AnonymousInterface
		AnonymousInterface anonymousObj = new AnonymousInterface() {

			@Override
			public void dynamite() {
				System.out.println("Hi, I Am AnonyMous");
			}
		};
		anonymousObj.dynamite();

		// LambdaInterface
		LambdaInterface useLambda = () -> System.out.println("Hello, I am Lambda");
		useLambda.tejas();

		// SumLambda Interface
		SumLambda sumObj = (a, b) -> a + b;
		System.out.println(sumObj.sum(3, 5));
		System.out.println(sumObj.sum(17, 14));

		// Length Interface
		Length lengthString = (s -> s.length());
		System.out.println(" Length Of The Given Word is " + lengthString.getLength("Tejas Here"));

		// Create Thread By using Lambda Expression
		Runnable threadOne = () -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("My Level is " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		};

		Thread t = new Thread(threadOne);
		t.start();
	}
}
