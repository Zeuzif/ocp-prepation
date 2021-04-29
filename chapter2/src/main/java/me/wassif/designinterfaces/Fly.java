package me.wassif.designinterfaces;

public interface Fly {
	int getWingSpan() throws Exception;
}

class Eagle implements Fly {

	// implementation could not throws the exception
	@Override
	public int getWingSpan() {
		return 10;
	}
}

// this is marker interface
interface Runner {
}
