package ServerStudyMiniProject.ServerStudyMiniProject.auth;

import ServerStudyMiniProject.ServerStudyMiniProject.auth.dto.LoginRequestDto;
import ServerStudyMiniProject.ServerStudyMiniProject.auth.dto.RegisterRequestDto;
import ServerStudyMiniProject.ServerStudyMiniProject.common.CommonResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "인증 API", description = "회원 가입 및 로그인 인증 API.")
@RequestMapping
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    public CommonResponse<?> userRegister(@RequestBody RegisterRequestDto registerRequestDto) {
        String registerMessage = authService.registerMember(registerRequestDto);
        return CommonResponse.postSuccess(HttpStatus.CREATED.value(), registerMessage);
    }

    /* 스프링 시큐리티는 /login 경로의 요청을 받아 인증 과정을 처리 */
    @PostMapping("/login")
    public CommonResponse<?> userLogin(@RequestBody LoginRequestDto loginRequestDto) {
        String loginMessage = authService.loginMember(loginRequestDto);
        return CommonResponse.postSuccess(HttpStatus.CREATED.value(), loginMessage);
    }
}