package com.capstone.trip.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.trip.config.auth.PrincipalDetail;
import com.capstone.trip.dto.accompany.AccompanySaveRequestDto;
import com.capstone.trip.service.AccompanyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AccompanyApiController {

	private final AccompanyService accompanyService;

	@PostMapping("/apply/accompany")
	@ResponseBody
	public void save(@RequestBody AccompanySaveRequestDto accompanySaveRequestDto,
		@AuthenticationPrincipal PrincipalDetail principalDetail) {
		Long userId = accompanySaveRequestDto.getUserId();
		Long boardId = accompanySaveRequestDto.getBoardId();
		String username = accompanySaveRequestDto.getUsername();
		String nickname = accompanySaveRequestDto.getNickname();
		String title = accompanySaveRequestDto.getTitle();
		accompanyService.save(userId, boardId, username, nickname, title, principalDetail.getUser());
	}

}