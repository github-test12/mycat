package dynamicProxy.cglib;

public class UserServiceImpl implements UserService{

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		System.out.println("____getName()-----");
		return "username";
	}

	@Override
	public String getAge() {
		// TODO Auto-generated method stub
		System.out.println("____getAge()-----");
		return "123";
	}

}
