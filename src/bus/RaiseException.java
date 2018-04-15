package bus;

public class RaiseException extends Exception{

	private static final long serialVersionUID = 8382864153537105517L;

	public RaiseException(){}
	
	public RaiseException (String msg){
		super(msg);
	}

}
