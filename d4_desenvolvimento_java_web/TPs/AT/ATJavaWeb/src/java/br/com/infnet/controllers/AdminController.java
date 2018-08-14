package br.com.infnet.controllers;

import br.com.infnet.dao.AutorDAO;
import br.com.infnet.dao.EditoraDAO;
import br.com.infnet.dao.LivroDAO;
import br.com.infnet.model.Autor;
import br.com.infnet.model.Editora;
import br.com.infnet.model.Livro;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    
    @Autowired
    private LivroDAO livroDao;   
    
    @Autowired
    private EditoraDAO editoraDao;
    
    @Autowired
    private AutorDAO autorDao;
    
    @RequestMapping("/admin")
    public String restrito(Model model) throws SQLException {
        String title = "ADMIN";
        model.addAttribute("title", title);
        model.addAttribute("lista", livroDao.listLivros());
        model.addAttribute("autores", autorDao.listAutor());
        model.addAttribute("editoras", editoraDao.listEditora());

        return "admin";
    }
    
    
    @RequestMapping(value = "/cadastrar/{tipo}", method = RequestMethod.GET)
    public ModelAndView cadastrar(Model model, @PathVariable("tipo") String tipo) throws SQLException {
    
        if (tipo.equals("livro")) {
            ModelAndView mv = new ModelAndView("livro");
            
            mv.addObject("title", "Cadastrar Livro");
            model.addAttribute("autores", autorDao.listAutor());
            model.addAttribute("editoras", editoraDao.listEditora());

            return mv;
        }
        
        
        if (tipo.equals("autor")) {
            ModelAndView mv = new ModelAndView("autor");
            mv.addObject("title", "Cadastrar Autor");
            
            return mv;
        }
        
        if (tipo.equals("editora")) {
            ModelAndView mv = new ModelAndView("editora");    
            mv.addObject("title", "Cadastrar Editora");
            
            return mv;
        }
        
        ModelAndView mv = new ModelAndView("admin");
        return mv;
        
    }
    
    
    @RequestMapping("/cadastrar-livro")
    public ModelAndView cadastrarLivro(Model model, @RequestParam("titulo") String titulo, @RequestParam("autor") int autor, @RequestParam("editora") int editora, @RequestParam("ano") int ano, @RequestParam("action") String action) throws SQLException {
        

        if (action.equals("add")) {
            
            ModelAndView mv = new ModelAndView("admin");
            
            //Cadastrar
            Livro livro = new Livro();
            livro.setTitulo(titulo);
            livro.setId_autor(autor);
            livro.setId_editora(editora);
            livro.setAno(ano);
            livroDao.addLivro(livro);
            
            //Retornar para Admin
            mv.addObject("title", "ADMIN");
            String msg = "Cadastro efetuado com sucesso!";
            mv.addObject("msg", msg);
            
            model.addAttribute("lista", livroDao.listLivros());
            model.addAttribute("autores", autorDao.listAutor());
            model.addAttribute("editoras", editoraDao.listEditora());
            
            return mv;
        }
        
        ModelAndView mv = new ModelAndView("livro");
        mv.addObject("title", "Cadastrar Livro");
        
        return mv;
    }
    
    @RequestMapping("/cadastrar-autor")
    public ModelAndView cadastrarAutor(Model model, @RequestParam String autor, @RequestParam String action) {
        
        String title = "Cadastrar Autor";
        model.addAttribute("title", title);
        
        if (action.equals("add")) {
            Autor a = new Autor();
            a.setAutor(autor);
            autorDao.addAutor(a);    
            String msg = "Cadastro efetuado com sucesso!";
            model.addAttribute("msg", msg);
            
            ModelAndView au = new ModelAndView("autor");
            return au;
        } 
        
        ModelAndView au = new ModelAndView("autor");
        return au;
    }
    
    @RequestMapping("/cadastrar-editora")
    public ModelAndView cadastrarEditora(Model model, @RequestParam String editora, @RequestParam String action) {
        String title = "Cadastrar Editora";
        model.addAttribute("title", title);
        
        if (action.equals("add")) {
            Editora e = new Editora();
            e.setEditora(editora);
            editoraDao.addEditora(e);
            String msg = "Cadastro efetuado com sucesso!";
            model.addAttribute("msg", msg);
            
            ModelAndView au = new ModelAndView("editora");
            return au;
        } 
        
        ModelAndView ed = new ModelAndView("editora");
        return ed;
    }
    
    @RequestMapping("livro/excluir/{id}")
    public ModelAndView excluirLivro(@PathVariable("id") int id) throws SQLException {
        String title = "Excluir Livro";
        ModelAndView mv = new ModelAndView("admin");
        mv.addObject("title", title);
        
        Livro l = new Livro();
        l.setId(id);
        
        livroDao.excluir(l);
        
        mv.addObject("lista", livroDao.listLivros());
        mv.addObject("autores", autorDao.listAutor());
        mv.addObject("editoras", editoraDao.listEditora());
        
        String msg = "Livro excluído com sucesso!";
        mv.addObject("msg", msg);
        
        return mv;
    }
    
    @RequestMapping("livro/editar/{id}")
    public ModelAndView editarLivro(@PathVariable("id") int id) throws SQLException {
        ModelAndView mv = new ModelAndView("editar");

        mv.addObject("title", "Editar Livro");
               
        mv.addObject("livro", livroDao.getLivro(id));
        mv.addObject("autores", autorDao.listAutor());
        mv.addObject("editoras", editoraDao.listEditora());
        
        return mv;
    }
    
    @RequestMapping("livro/alterar")
    public ModelAndView alterarLivro(@RequestParam("id")int id, @RequestParam("titulo")String titulo, @RequestParam("autor")int autor, @RequestParam("editora")int editora, @RequestParam("ano")int ano) throws SQLException {
        ModelAndView mv = new ModelAndView("admin");

        //Update
        Livro l = new Livro();
        l.setId(id);
        l.setTitulo(titulo);
        l.setId_autor(autor);
        l.setId_editora(editora);
        l.setAno(ano);
        
        livroDao.update(l);
        
        //Retornar para Admin
            mv.addObject("title", "ADMIN");
            String msg = "Alteração efetuada com sucesso!";
            mv.addObject("msg", msg);
            
            mv.addObject("lista", livroDao.listLivros());
            mv.addObject("autores", autorDao.listAutor());
            mv.addObject("editoras", editoraDao.listEditora());
        
        return mv;
    }
    
}
