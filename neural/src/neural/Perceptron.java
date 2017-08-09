package neural;

public class Perceptron {
	public double getBias() {
		return bias;
	}

	public double getWx() {
		return wx;
	}

	public double getWy() {
		return wy;
	}

	double bias;
	double wx;
	double wy;
	
	public Perceptron(double bias, double wx, double wy){
		this.bias = bias;
		this.wx = wx;
		this.wy = wy;
	}

	public int synapsis(double a, double b){
		if (wx*a+wy*b+bias > 0){
			return 1;
		}
		return 0;
	}
	
	public void train(double learnRate, double inputX, double inputY, int desiredOutput) throws Exception {
		if (desiredOutput<0 || desiredOutput>1) {
			throw new Exception("Output must be binary");
		}
		int output = this.synapsis(inputX, inputY);
		if (output != desiredOutput) {
			if (desiredOutput == 0) {
				// Disminuir pesos
				wx -= learnRate*inputX;
				wy -= learnRate*inputY;
			} else {
				// Aumentar pesos
				wx += learnRate*inputX;
				wy += learnRate*inputY;
			}
		}
		
		
	}

}
