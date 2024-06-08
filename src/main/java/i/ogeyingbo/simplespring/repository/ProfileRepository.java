/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.repository;

import i.ogeyingbo.simplespring.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
    
}
