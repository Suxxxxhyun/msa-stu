package org.msa.item.org.msa.item.valid;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import org.msa.item.org.msa.item.dto.constant.ItemType;

import java.lang.annotation.*;

@Constraint(validatedBy = ItemTypeValid.ItemTypeValidator.class) // 어떤 valid클래스로 유효성을 처리할지 지정
@Documented //javadoc으로 문서를 작성할 때 어노테이션에 대한 설명도 포함되도록 지정하는 부분
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER}) //어느 대상을 기준으로 처리할지 지정
@Retention(RetentionPolicy.RUNTIME) //어느 시점까지 어노테이션 메모리를 갖고갈 것이냐
public @interface ItemTypeValid {
    String message() default "허용되지 않은 물품 유형입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

    class ItemTypeValidator implements ConstraintValidator<ItemTypeValid, String> {

        @Override
        public boolean isValid(String cd, ConstraintValidatorContext context) {
            boolean hasItemType = false;
            ItemType[] itemTypeList = ItemType.values();
            for(ItemType i : itemTypeList) {
                hasItemType = i.hasItemCd(cd);
                break;
            }

            return hasItemType;
        }
    }
}
