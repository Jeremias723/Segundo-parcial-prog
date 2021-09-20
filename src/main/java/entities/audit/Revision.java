package entities.audit;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import lombok.Data;

@Entity
@Table
@RevisionEntity
@Data
public class Revision {
	
	private static final long serialVersionId = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="revision_seq")
	@SequenceGenerator(
			name = "revision_seq",
			sequenceName = "rbac.seq_revision_id"
			)
	
	@RevisionNumber
	private int id;
	
	@Column(name="REVISION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@RevisionTimestamp
	private Date date;

}
