package org.example.share.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class ResponseWithPagination<T> {
    private Integer start;
    private Integer limit;
    private String order;
    private String sort;
    private List<T> data;

    private ResponseStatus status;
}
