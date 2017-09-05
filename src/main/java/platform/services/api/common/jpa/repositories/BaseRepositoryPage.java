package platform.services.api.common.jpa.repositories;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BaseRepositoryPage<T> extends PageImpl<T> {

    public BaseRepositoryPage(final List<T> content, final Pageable pageable, final long total) {

        super(content, pageable, total);
    }

    public BaseRepositoryPage(final List<T> content) {

        super(content);
    }
//public class BaseRepositoryPage<T> extends PageImpl<T> implements Page<T> {

//    private static final long serialVersionUID = 3248189030448292002L;
//
//    public BaseRepositoryPage(List<T> content, Pageable pageable, long total) {
////    public BaseRepositoryPage(List<T> content, BasePageable pageable, long total) {
//
//        super(content, pageable, total);
//
//        Tracing.trace("BaseRepositoryPage(List<T> content, BasePageable pageable, long total): {}, {}, {}", content.toString(), pageable.toString(), total);
//    }
//
//    public BaseRepositoryPage(List<T> content) {
//
//        super(content);
//
//        Tracing.trace("BaseRepositoryPage(List<T> content): {}", content.toString());
//    }
//
//    public BaseRepositoryPage() {
//
//        super(new ArrayList<T>());
//
//        Tracing.trace("BaseRepositoryPage()");
//
//    }

}
