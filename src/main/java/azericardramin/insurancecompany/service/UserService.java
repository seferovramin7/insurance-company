package azericardramin.insurancecompany.service;

import azericardramin.insurancecompany.main_exception.ResourceNotFoundException;
import azericardramin.insurancecompany.model.Company;
import azericardramin.insurancecompany.model.User;
import azericardramin.insurancecompany.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<User> getAll() throws ResourceNotFoundException {
        List<User> users = (List<User>) userRepository.findAll();
        if (users.isEmpty()){
            throw new ResourceNotFoundException("No Data Found!");
        }
        return users;
    }


    public User createUser(User user){
        return userRepository.save(user);
    }


    public Map<String, Boolean> deleteUser(Long userId)
            throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow( () -> new ResourceNotFoundException("User couldnt deleted : " + userId));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }




}
