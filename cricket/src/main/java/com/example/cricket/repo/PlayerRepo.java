package com.example.cricket.repo;

import com.example.cricket.entity.Player;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PlayerRepo extends ElasticsearchRepository<Player, String> {
}
