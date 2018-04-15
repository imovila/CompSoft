package bus;

import java.io.Serializable;

public class Sequence implements Serializable{

	private static final long serialVersionUID = -1562588329591735071L;
	private static int idx = 1;

	public static int getIdx() {
		return Sequence.idx++;
	}

	public static void setIdx(int idx) throws RaiseException {
		Validation.validInt(String.valueOf(idx));
		Sequence.idx = idx;
	}
}
