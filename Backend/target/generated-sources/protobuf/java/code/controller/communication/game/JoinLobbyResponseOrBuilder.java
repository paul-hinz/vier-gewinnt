// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Game.proto

// Protobuf Java Version: 3.25.1
package code.controller.communication.game;

public interface JoinLobbyResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:JoinLobbyResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool success = 1;</code>
   * @return The success.
   */
  boolean getSuccess();

  /**
   * <pre>
   *name of the enemy that is waiting in the lobby
   * </pre>
   *
   * <code>string enemyName = 2;</code>
   * @return The enemyName.
   */
  java.lang.String getEnemyName();
  /**
   * <pre>
   *name of the enemy that is waiting in the lobby
   * </pre>
   *
   * <code>string enemyName = 2;</code>
   * @return The bytes for enemyName.
   */
  com.google.protobuf.ByteString
      getEnemyNameBytes();

  /**
   * <code>int32 gameTime = 3;</code>
   * @return The gameTime.
   */
  int getGameTime();

  /**
   * <code>int32 boardRowCount = 4;</code>
   * @return The boardRowCount.
   */
  int getBoardRowCount();

  /**
   * <code>int32 boardColCount = 5;</code>
   * @return The boardColCount.
   */
  int getBoardColCount();

  /**
   * <code>int32 clientID = 6;</code>
   * @return The clientID.
   */
  int getClientID();
}
