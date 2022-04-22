package com.example.unitTestsHomework.service;
import com.example.unitTestsHomework.model.UserModel;
import com.example.unitTestsHomework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public void updateUser(Integer userId, UserModel userModel){
        userRepository.findById(userId).get().setUsername(userModel.getUsername());
        userRepository.findById(userId).get().setFirstName(userModel.getFirstName());
        userRepository.findById(userId).get().setLastName(userModel.getLastName());

    }
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }


}
