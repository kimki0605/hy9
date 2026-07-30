package anonymousex.interfaceex.ui;

public class Button {
	OnClickListener Listener;
	public void setListener(OnClickListener Listener) {
		this.Listener = Listener; 
	}
	void touch() {
		Listener.onClick();
	}
	
	interface OnClickListener{
		void onClick();
	}
}
