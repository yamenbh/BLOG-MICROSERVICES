package ma.emsi.post.service.impl;

import ma.emsi.post.model.Utilisateur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-utilisateur")
public interface UtilisateurService {

	@GetMapping("blog/utilisateur/email/{email}")
	Utilisateur getUtilisateurByEmail(@PathVariable("email") String email);

	@GetMapping("blog/utilisateur/{id}")
	Utilisateur getUtilisateurById(@PathVariable("id") int id);

	@PostMapping("blog/utilisateur")
	void addUtilisateur(@RequestBody Utilisateur u);
}
