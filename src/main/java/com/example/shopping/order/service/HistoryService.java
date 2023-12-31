package com.example.shopping.order.service;

import com.example.shopping.order.domain.entity.History;
import com.example.shopping.order.domain.request.HistoryRequest;
import com.example.shopping.order.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HistoryService {
    private final HistoryRepository historyRepository;

    public List<History> findAllHistory() {
        return historyRepository.findAll();
    }

    public void saveHistory(HistoryRequest historyRequest, Long productSeq) {
        historyRepository.save(historyRequest.toEntity(productSeq));
    }

    public void deleteHistory(Long historySeq) {
        historyRepository.deleteById(historySeq);
    }
}
