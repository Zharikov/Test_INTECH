package com.intech.forum.repositories;

import com.intech.forum.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

//    Page<Topic> findAll(Pageable pageable);

    Long countTopicsByUser_Id(Long id);

    Topic findTopicById(Long id);

    //List<Topic> findTopicsByCategoryOrderByCreatedDateDesc(String category);
    List<Topic> findTopicsByUser_IdOrderByCreatedDateDesc(Long id);
}
