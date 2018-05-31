package fr.thulj.corpogames.dao

import fr.thulj.corpogames.domain.Survey
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface SurveyRepository : CrudRepository<Survey,Int>