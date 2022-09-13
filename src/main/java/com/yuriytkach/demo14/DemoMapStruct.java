package com.yuriytkach.demo14;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

public class DemoMapStruct {

  public static void main(String[] args) {
    var source = new Source("hello", 42);

    final SourceTargetMapper mapper = Mappers.getMapper(SourceTargetMapper.class);

    final Target target = mapper.sourceToTarget(source);
    System.out.println(target);

    System.out.println(mapper.sourceToTarget2(source, Boolean.FALSE));
  }

  @Mapper(
    unmappedTargetPolicy = ReportingPolicy.ERROR
  )
  public interface SourceTargetMapper {

    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "value", target = "number")
    Target sourceToTarget(Source source);

    @Mapping(target = "active", source = "active")
    @Mapping(target = "name", expression = "java(source.getName() == null ? \"HELLO\" : source.getName())")
    @Mapping(target = "value", source = "source.value")
    Target2 sourceToTarget2(Source source, boolean active);

    default Optional<Boolean> mapBoolean(boolean value) {
      return Optional.ofNullable(value);
    }
  }

}
