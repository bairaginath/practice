

class NEv1 {
	private String ipAddress;
	private String port;
	private String vender;
	private String layer;

	private NEv1(String ipAddress, String port) {
		this.ipAddress = ipAddress;
		this.port = port;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getPort() {
		return port;
	}

	public String getVender() {
		return vender;
	}

	public String getLayer() {
		return layer;
	}

	public static Builder getBuilder(String ipAddress, String port) {
		return new Builder(ipAddress, port);
	}

	static class Builder {
		private String ipAddress;
		private String port;
		private String vender;
		private String layer;

		public NEv1 build() {
			if (this.ipAddress == null || this.port == null)
				throw new NullPointerException();
			NEv1 ne = new NEv1(this.ipAddress, this.port);
			ne.vender = this.vender;
			ne.layer = this.layer;
			return ne;
		}

		
		public Builder setVender(String vender) {
			this.vender = vender;
			return this;
		}

		public Builder setLayer(String layer) {
			this.layer = layer;
			return this;
		}

		private Builder(String ipAddress, String port) {
			this.ipAddress = ipAddress;
			this.port = port;
		}

	}

}


public class BuilderExampleV1 {
	public static void main(String[] args) {
		
		NEv1 ne=NEv1.getBuilder("22.22.22.22","3333").build(); //only mendatary fields
		System.out.println(ne);
		
		NEv1 ne1=NEv1.getBuilder("44.44.44.44","3343").setLayer("WDM")
				.setVender("quantum").build(); //here mendatory with optional
		System.out.println(ne1);
		
		
	}
}