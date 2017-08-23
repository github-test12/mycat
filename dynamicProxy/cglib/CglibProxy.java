package dynamicProxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("befor" + methodProxy.getSuperName() + "******");
		System.out.println(method.getName());
		Object object = methodProxy.invokeSuper(obj, args);
		System.out.println("after" + methodProxy.getSuperName() + "******");
		
		return object;
	}

	public static void main(String[] args) {
		
		CglibProxy cglibProxy = new CglibProxy();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);
		enhancer.setCallback(cglibProxy);
		
		UserService userServiceProxy = (UserService) enhancer.create();
		userServiceProxy.getName();
		userServiceProxy.getAge();
	}
}
