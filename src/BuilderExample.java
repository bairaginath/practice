

class NE {
	private String ipAddress;
	private String port;
	private String vender;
	private String layer;

	private NE(String ipAddress, String port) {
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

	static class Builder {
		private String ipAddress;
		private String port;
		private String vender;
		private String layer;

		public NE build() {
			if (this.ipAddress == null || this.port == null)
				throw new NullPointerException();
			NE ne = new NE(this.ipAddress, this.port);
			ne.vender = this.vender;
			ne.layer = this.layer;
			return ne;
		}

		public Builder setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
			return this;
		}

		public Builder setPort(String port) {
			this.port = port;
			return this;
		}

		public Builder setVender(String vender) {
			this.vender = vender;
			return this;
		}

		public Builder setLayer(String layer) {
			this.layer = layer;
			return this;
		}

		public Builder(String ipAddress, String port) {
			this.ipAddress = ipAddress;
			this.port = port;
		}

		public Builder() {
		}

	}

}

public class BuilderExample {

	public static void main(String[] args) {
		NE ne = new NE.Builder("135.443.33.33", "3433").build();
		System.out.println(ne);
		// NE ne1=new NE.Builder().build(); // it will throw
		// NullPointerException
		NE ne2 = new NE.Builder().setIpAddress("sdfasdf").setPort("sdfasdf").build();
		System.out.println(ne2);

	}

}
