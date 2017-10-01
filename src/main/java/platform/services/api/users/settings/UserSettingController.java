package platform.services.api.users.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.services.api.commons.controller.BaseController;

@RestController
//@RequestMapping(value = "/users/{userId:^[0-9]{1,16}}$/settings", produces = "application/hal+json")
@RequestMapping(value = "/users/{root_uuid:^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$}/settings", produces = "application/hal+json")
public class UserSettingController extends BaseController<UserSettingService, UserSettingRepository, UserSetting> {

    private final UserSettingService service;

    @Autowired public UserSettingController(final UserSettingService service) {

        super(service);

        this.service = service;

    }

//    @RequestMapping(method = RequestMethod.POST, value = "")
//    public ResponseEntity<UserSetting> postForIndex(@RequestBody final UserSetting entity, @PathVariable("userId") final String userId) {
//
//        return basePostForIndex(userId, entity);
//
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/")
//    public ResponseEntity<E> postForIndex(@PathVariable final Long userId, final E entity) {
//
//        entity.setParentId(userId);
//
//        return new ThrowableResponseEntity<>(genericService.save(entity), HttpStatus.CREATED);
//
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = ConstraintPatterns.CONSTRAINT_UUID_PATTERN)
//    public ResponseEntity<E> postForEntity(@PathVariable final String userId, @PathVariable final UUID uuid, @RequestBody final E entity) {
//
//        return new ThrowableResponseEntity<>(genericService.save(entity), HttpStatus.CREATED);
//
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "")
//    public ResponseEntity<Page<E>> indexGetAll(final Pageable pageable) {
//
//        return new ThrowableResponseEntity<>(genericService.findAll(pageable));
//
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = ConstraintPatterns.CONSTRAINT_UUID_PATTERN)
//    public ResponseEntity<E> indexGetByUUID(@PathVariable final UUID uuid) {
//
//        return new ThrowableResponseEntity<>(genericService.getByUuid(uuid));
//
//    }
//
////    @RequestMapping(method = RequestMethod.POST, value = ConstraintPatterns.CONSTRAINT_UUID_PATTERN)
////    public ResponseEntity<E> indexPostByUUID(@RequestBody final E entity) {
////
////        genericService.save(entity);
////
////        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////
////    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = ConstraintPatterns.CONSTRAINT_UUID_PATTERN)
//    public ResponseEntity<E> indexPutByUUID(@RequestBody final E entity) {
//
//        genericService.save(entity);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }
//
//    @RequestMapping(method = RequestMethod.PATCH, value = ConstraintPatterns.CONSTRAINT_UUID_PATTERN)
//    public ResponseEntity<E> indexPatchByUUID(@RequestBody final E entity) {
//
//        genericService.save(entity);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = ConstraintPatterns.CONSTRAINT_UUID_PATTERN)
//    public ResponseEntity<E> indexDeleteByUUID(@PathVariable final UUID uuid) {
//
//        return new ResponseEntity<>((genericService.deleteByUuid(uuid)) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
//
//    }

}
