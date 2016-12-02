/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-10-17 16:43:55 UTC)
 * on 2016-12-02 at 05:50:40 UTC 
 * Modify at your own risk.
 */

package com.example.admin.myapplication.backend.myApi.model;

/**
 * Model definition for ExerciseDetailData.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the myApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class ExerciseDetailData extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<java.lang.String> bodyparts;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<java.lang.Object> data;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String description;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer difficulty;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String direction;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<java.lang.String> equipments;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<java.lang.String> injuries;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String link;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String name;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String warning;

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<java.lang.String> getBodyparts() {
    return bodyparts;
  }

  /**
   * @param bodyparts bodyparts or {@code null} for none
   */
  public ExerciseDetailData setBodyparts(java.util.List<java.lang.String> bodyparts) {
    this.bodyparts = bodyparts;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<java.lang.Object> getData() {
    return data;
  }

  /**
   * @param data data or {@code null} for none
   */
  public ExerciseDetailData setData(java.util.List<java.lang.Object> data) {
    this.data = data;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDescription() {
    return description;
  }

  /**
   * @param description description or {@code null} for none
   */
  public ExerciseDetailData setDescription(java.lang.String description) {
    this.description = description;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getDifficulty() {
    return difficulty;
  }

  /**
   * @param difficulty difficulty or {@code null} for none
   */
  public ExerciseDetailData setDifficulty(java.lang.Integer difficulty) {
    this.difficulty = difficulty;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDirection() {
    return direction;
  }

  /**
   * @param direction direction or {@code null} for none
   */
  public ExerciseDetailData setDirection(java.lang.String direction) {
    this.direction = direction;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<java.lang.String> getEquipments() {
    return equipments;
  }

  /**
   * @param equipments equipments or {@code null} for none
   */
  public ExerciseDetailData setEquipments(java.util.List<java.lang.String> equipments) {
    this.equipments = equipments;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<java.lang.String> getInjuries() {
    return injuries;
  }

  /**
   * @param injuries injuries or {@code null} for none
   */
  public ExerciseDetailData setInjuries(java.util.List<java.lang.String> injuries) {
    this.injuries = injuries;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getLink() {
    return link;
  }

  /**
   * @param link link or {@code null} for none
   */
  public ExerciseDetailData setLink(java.lang.String link) {
    this.link = link;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * @param name name or {@code null} for none
   */
  public ExerciseDetailData setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getWarning() {
    return warning;
  }

  /**
   * @param warning warning or {@code null} for none
   */
  public ExerciseDetailData setWarning(java.lang.String warning) {
    this.warning = warning;
    return this;
  }

  @Override
  public ExerciseDetailData set(String fieldName, Object value) {
    return (ExerciseDetailData) super.set(fieldName, value);
  }

  @Override
  public ExerciseDetailData clone() {
    return (ExerciseDetailData) super.clone();
  }

}
