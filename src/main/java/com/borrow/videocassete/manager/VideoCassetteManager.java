package com.borrow.videocassete.manager;

import com.borrow.videocassete.dao.VideoCassetteRepository;
import com.borrow.videocassete.dao.entity.VideoCassette;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepository videoCassetteRepository;

    public VideoCassetteManager(VideoCassetteRepository videoCassetteRepository) {
        this.videoCassetteRepository = videoCassetteRepository;
    }

    public Optional<VideoCassette> findById(Long id) {

        return videoCassetteRepository.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepository.findAll();
    }

    public void deleteById(Long id) {

        videoCassetteRepository.deleteById(id);
    }

    public VideoCassette save(VideoCassette videoCassette){
        return videoCassetteRepository.save(videoCassette);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase(){
        save(new VideoCassette(1L, "Rambo", LocalDate.of(1987, 1, 1)));
        save(new VideoCassette(2L, "Wilk", LocalDate.of(1991, 1, 1)));
    }
}
