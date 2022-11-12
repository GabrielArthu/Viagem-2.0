package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViagemController {

	@Autowired
	ViagemRepository viagemRepository;
	
	@RequestMapping("/")
	public String inicio() {
		return "index";
	}
	
	@RequestMapping("/read")
	public String listaViagem(Model model) {
		model.addAttribute("viagens", viagemRepository.findAll());
		return "lista";
	}
	
	
	@GetMapping("/add")
	public String viagemForm(Model model) {
	model.addAttribute("viagem",new Viagem());
	return "viagemForm";
	}
	
	@PostMapping("/process")
	public String processForm(@Valid Viagem viagem, BindingResult result) {
		if(result.hasErrors()) {
	
			return "viagemForm";
		}
		viagemRepository.save(viagem);
		return "redirect:/read";
	}
	
	
	@GetMapping("/viagem/{id}")
	public ResponseEntity<Viagem> getViagemById(@PathVariable Long id){
		Viagem viagem = viagemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("O funcionario não existe ou não  foi encontrada pelo id" + id));
		return ResponseEntity.ok(viagem);
	}
	
	
	//Alterar um funcionario 
		@PutMapping("/viagemup/{id}")
		public ResponseEntity<Viagem> updateFuncionario(@PathVariable Long id,@RequestBody Viagem funcionarioDetails ) {
			Viagem viagem = viagemRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Funcionario não existe pelo ID"+ id));
			
			viagem.setTitulo(funcionarioDetails.getTitulo());
			viagem.setCidade(funcionarioDetails.getCidade());
			viagem.setEstado(funcionarioDetails.getEstado());
			
			Viagem updatedViagem = viagemRepository.save(viagem);
			return ResponseEntity.ok(updatedViagem);
		}
		
		@DeleteMapping("/delete/{id}")
		public String deletarViagem(long id) {
			Viagem viagem = viagemRepository.getViagemById(id);
			viagemRepository.delete(viagem);
			return"redirect:/";
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	@RequestMapping("/{id}")
	public ModelAndView usersViagem(@PathVariable("id") long id) {
		Viagem viagem = viagemRepository.findById(id);
		ModelAndView mv = new ModelAndView("usuarioViagem"); 
		mv.addObject("viagem",viagem);
		return mv;
	}**/
}	




















