package com.rubber_duck.RestService.service;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rubber_duck.RestService.model.Image;
import com.rubber_duck.RestService.model.Motion;
import com.rubber_duck.RestService.repository.ImageRepository;
import com.rubber_duck.RestService.repository.MotionRepository;
import com.rubber_duck.RestService.util.ImageUtil;

@Service
public class MotionService {

    @Autowired
    private MotionRepository motionRepository;

    @Autowired
    private ImageRepository imageRepository;

    public boolean createMotion(MultipartFile file) {
        Motion motion = new Motion();
        try {
            motion.setDetectedTime(Instant.now());
            motion.setId(UUID.randomUUID().toString());
            Image image = new Image();
            image.setId(UUID.randomUUID().toString());
            image.setName(file.getOriginalFilename());
            byte[] bytes = ImageUtil.compressImage(file.getBytes());
            image.setImage(bytes);
            image.setType("png");
            imageRepository.save(image);
            Motion createdMotion = motionRepository.save(motion);
            if (createdMotion.getId().equals(motion.getId())) {
                return true;
            }
        } catch (IOException error) {
            System.out.println("IOException found: " + error);
        }
        return false;
    }

    public List<Motion> listMotion(Integer days) {
        Instant now = Instant.now();
        Instant value = now.minus(days, ChronoUnit.DAYS);
        return motionRepository.findByDays(value);
    }

    public byte[] getMotion(String name) {
        Image image = imageRepository.findByName(name);
        if (image != null) {
            byte[] bytes = ImageUtil.decompressImage(image.getImage());
            return bytes;
        }
        return new byte[0];
    }
}
