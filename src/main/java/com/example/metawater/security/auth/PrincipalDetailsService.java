//package com.example.metawater.security.auth;
//
//import com.example.metawater.domain.MemberVO;
//import com.example.metawater.mapper.MemberMapper;
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class PrincipalDetailsService implements UserDetailsService{
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private final MemberMapper memberMapper;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		logger.info("------------------------------------------");
//		logger.info("username : {}" , username);
//		System.out.println("PrincipalDetailsService : 진입");
//		MemberVO member = memberMapper.findByUserId(username);
//		logger.info("member :: {}", member);
//		if(member != null){
//			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//			String roles[] = member.getRoles().split(",");
//			for(int i =0 ;i< roles.length; i++){
//				authorities.add(new SimpleGrantedAuthority(roles[i]));
//			}
//			logger.info("----------------if문 -------------------");
//			return new PrincipalDetails(member);
//		}
//
//		// session.setAttribute("loginUser", user);
//		logger.info("------------------------------------------");
//		return null; //SecurityContext의 Authentication에 등록되어 인증정보를 가진다.
//	}
//}
