package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ChatLiveDto;
import com.example.demo.model.ChatLive;


@Repository
public interface ChatLiveRepository extends JpaRepository<ChatLive,Integer>{

	void deleteByTunnelid(int tunnelid);

	List<ChatLive> findByTunnelid(int tunnelid);

	ChatLive save(ChatLiveDto chat);


}
