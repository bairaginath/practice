
interface Driver{
	
	void getConnection();
	void prepareStatement();
	void close();
}

// common driver implementation

class JdbcDriver implements Driver 
{

	@Override
	public void getConnection() {
		System.out.println("common connection method");
	}

	@Override
	public void close() {
        System.out.println("common close method");		
	}

	@Override
	public void prepareStatement() {
		System.out.println("common prepareStatement");		
	}
	
}

interface MySQLJdbcDriverAdptor 
{
	void getConnection();
	void prepareStatement();
	
}

class MySQlJdbcDriver extends JdbcDriver implements MySQLJdbcDriverAdptor
{
	@Override
	public void getConnection() {
		System.out.println("mysql connection method");
	}

	@Override
	public void prepareStatement() {
        System.out.println("mysql prepareStatement");		
	}

	
}


interface OracleJdbcDriverAdptor 
{
	void getConnection();
	void prepareStatement();
	
	
}

class OracleJdbcDriver extends JdbcDriver implements OracleJdbcDriverAdptor
{
	@Override
	public void getConnection() {
		System.out.println("oracle connection method");
	}

	@Override
	public void prepareStatement() {
		System.out.println("oracle prepareStatement");		
	}

	
}


public class AdptorDesignExample {
	
	public static void main(String[] args) {
		Driver driver=new MySQlJdbcDriver();
		driver.getConnection();
		driver.prepareStatement();
		driver.close();
		Driver driver1=new OracleJdbcDriver();
		driver1.getConnection();
		driver.prepareStatement();
		driver.close();
	}

}
