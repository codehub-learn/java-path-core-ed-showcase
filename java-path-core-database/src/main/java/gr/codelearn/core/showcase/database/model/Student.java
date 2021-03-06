
package gr.codelearn.core.showcase.database.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String email;
    private Integer age;
    private Integer departmentId;
}
