package practice.crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.crud.domain.Board;
import practice.crud.service.BoardService;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("board", boardService.getList());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.detail(id));
        return "detail";
    }

    @GetMapping("/create")
    public String createGet(){
        return "create";
    }

    @PostMapping("/create")
    public String createPost(Board board){
        boardService.create(board);
        return "redirect:/board/list";
    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.detail(id));
        return "update";
    }

    @PostMapping("/update")
    public String updatePost(Board board){
        boardService.update(board);
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        boardService.delete(id);
        return "redirect:/board/list";
    }

}
