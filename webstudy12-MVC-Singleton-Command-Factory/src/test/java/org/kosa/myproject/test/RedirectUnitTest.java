package org.kosa.myproject.test;

public class RedirectUnitTest {
	public static void main(String[] args) {
		String url = "redirect:register-result.jsp";
		//서두 prefix가 redirect로 시작되는가?
		System.out.println(url.trim().startsWith("redirect:"));
		System.out.println(url.trim().substring(9)); // 맨 첫 문자는 인덱스가 0 , trim()은 양 여백을 제거
	}
}
