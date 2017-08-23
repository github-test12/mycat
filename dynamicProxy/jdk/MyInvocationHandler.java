package dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

	private Object obj;
	
	MyInvocationHandler(){
		
	}
	
	MyInvocationHandler(Object obj){
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		if("getName".equals(method.getName())){
			System.out.println("before" + method.getName() +"******");
			Object result = method.invoke(obj, args);
			System.out.println("after"+method.getName()+"******");
			return result;
		}else{
			Object result = method.invoke(obj, args);
			return result;
		}
	}
	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		InvocationHandler invocationHandler = new MyInvocationHandler(userService);
		
		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
							userService.getClass().getClassLoader(),
							userService.getClass().getInterfaces(), 
							invocationHandler);
		System.out.println(userServiceProxy.getName());
		System.out.println(userServiceProxy.getAge());
	}

}
