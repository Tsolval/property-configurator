package net.tsolval.config.data

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="PROPERTIES", schema="PUBLIC")
class Property {
	@Id
	Long id
	String context
	String key
	String value
	String description
}
