package linsglf.picpaysimplificado.assembler;

import linsglf.picpaysimplificado.domain.response.UserResponse;
import linsglf.picpaysimplificado.domain.user.User;
import linsglf.picpaysimplificado.domain.user.UserMerchant;
import linsglf.picpaysimplificado.domain.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserAssembler {

    private final ModelMapper modelMapper;

    public UserAssembler() {
        this.modelMapper = new ModelMapper().registerModule(new RecordModule());
    }

    public UserResponse toResponse(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserResponse.class);
    }

    public UserResponse toResponse(User user) {
        return modelMapper.map(user, UserResponse.class);
    }

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntityCommon(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserMerchant toEntityMerchant(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserMerchant.class);
    }

    public List<UserResponse> toResponseList(List<User> users) {
        return users.stream()
                .map( user -> modelMapper.map(user, UserResponse.class))
                .toList();
    }
}
