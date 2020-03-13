
interface Driver{
	
	void getConnection();
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
	
}

interface MySQLJdbcDriverAdptor 
{
	void getConnection();
	
}

class MySQlJdbcDriver extends JdbcDriver implements MySQLJdbcDriverAdptor
{
	@Override
	public void getConnection() {
		System.out.println("mysql connection method");
	}

	
}


interface OracleJdbcDriverAdptor 
{
	void getConnection();
	
}

class OracleJdbcDriver extends JdbcDriver implements OracleJdbcDriverAdptor
{
	@Override
	public void getConnection() {
		System.out.println("oracle connection method");
	}

	
}


public class AdptorDesignExample {
	
	public static void main(String[] args) {
		Driver driver=new MySQlJdbcDriver();
		driver.getConnection();
		driver.close();
		Driver driver1=new OracleJdbcDriver();
		driver1.getConnection();
		driver.close();
	}

}
