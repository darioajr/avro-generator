/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package br.com.b3.poc.generate.avro.app.model.avro.meuregistro;
@org.apache.avro.specific.AvroGenerated
public enum Status implements org.apache.avro.generic.GenericEnumSymbol<Status> {
  ATIVO, INATIVO  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Status\",\"namespace\":\"br.com.b3.poc.generate.avro.app.model.avro.meuregistro\",\"symbols\":[\"ATIVO\",\"INATIVO\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}