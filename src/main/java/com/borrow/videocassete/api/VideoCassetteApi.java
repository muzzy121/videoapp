package com.borrow.videocassete.api;

import com.borrow.videocassete.dao.entity.VideoCassette;
import com.borrow.videocassete.manager.VideoCassetteManager;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassettes") // <- maps api only, root place where i should get an access to methods aka. ( localhost:8080/api/cassettes?id=1 )
public class VideoCassetteApi {

    private VideoCassetteManager videoCassetteList;

//    private List<VideoCassette> videoCassetteList;

    public VideoCassetteApi(VideoCassetteManager videoCassetteList) {
//        videoCassetteList = new ArrayList<>();
        this.videoCassetteList = videoCassetteList;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassetteList.findAll();
    }

    @GetMapping()
    public Optional<VideoCassette> getById(@RequestParam long id) {
            return videoCassetteList.findById(id);
//          Optional<VideoCassette> videoCassette = videoCassetteList.stream().filter(x -> x.getId() == id).findFirst();
//          return videoCassette.get();
    }

    @PostMapping()
    public boolean addCassette(@RequestBody VideoCassette videoCassette) {
        return videoCassetteList.add(videoCassette);
    }

    @PutMapping() // <- nadpisuje element
    public boolean updateCassette(@RequestBody VideoCassette videoCassette) {
        return videoCassetteList.add(videoCassette);
    }

    @DeleteMapping()
    public boolean deleteCassette(@RequestParam int id){
        return videoCassetteList.removeIf(videoCassette -> videoCassette.getId() == id);
    }


}
