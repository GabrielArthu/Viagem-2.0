package config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.UserModel;
import com.example.demo.UserRepository;

@Service
public class UserDetailsServeceImpl implements UserDetailsService {

	
	final UserRepository userRepository;
	public UserDetailsServeceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found"+ username));
		return userModel;
	}

}
