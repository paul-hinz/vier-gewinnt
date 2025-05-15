package code.controller.communication.game;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: Game.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GameGrpc {

  private GameGrpc() {}

  public static final java.lang.String SERVICE_NAME = "Game";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<code.controller.communication.game.Void,
      code.controller.communication.game.GetLobbiesResponse> getGetLobbiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLobbies",
      requestType = code.controller.communication.game.Void.class,
      responseType = code.controller.communication.game.GetLobbiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<code.controller.communication.game.Void,
      code.controller.communication.game.GetLobbiesResponse> getGetLobbiesMethod() {
    io.grpc.MethodDescriptor<code.controller.communication.game.Void, code.controller.communication.game.GetLobbiesResponse> getGetLobbiesMethod;
    if ((getGetLobbiesMethod = GameGrpc.getGetLobbiesMethod) == null) {
      synchronized (GameGrpc.class) {
        if ((getGetLobbiesMethod = GameGrpc.getGetLobbiesMethod) == null) {
          GameGrpc.getGetLobbiesMethod = getGetLobbiesMethod =
              io.grpc.MethodDescriptor.<code.controller.communication.game.Void, code.controller.communication.game.GetLobbiesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLobbies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.Void.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.GetLobbiesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameMethodDescriptorSupplier("GetLobbies"))
              .build();
        }
      }
    }
    return getGetLobbiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<code.controller.communication.game.CreateLobbyRequest,
      code.controller.communication.game.CreateLobbyResponse> getCreateLobbyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLobby",
      requestType = code.controller.communication.game.CreateLobbyRequest.class,
      responseType = code.controller.communication.game.CreateLobbyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<code.controller.communication.game.CreateLobbyRequest,
      code.controller.communication.game.CreateLobbyResponse> getCreateLobbyMethod() {
    io.grpc.MethodDescriptor<code.controller.communication.game.CreateLobbyRequest, code.controller.communication.game.CreateLobbyResponse> getCreateLobbyMethod;
    if ((getCreateLobbyMethod = GameGrpc.getCreateLobbyMethod) == null) {
      synchronized (GameGrpc.class) {
        if ((getCreateLobbyMethod = GameGrpc.getCreateLobbyMethod) == null) {
          GameGrpc.getCreateLobbyMethod = getCreateLobbyMethod =
              io.grpc.MethodDescriptor.<code.controller.communication.game.CreateLobbyRequest, code.controller.communication.game.CreateLobbyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLobby"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.CreateLobbyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.CreateLobbyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameMethodDescriptorSupplier("CreateLobby"))
              .build();
        }
      }
    }
    return getCreateLobbyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<code.controller.communication.game.JoinLobbyRequest,
      code.controller.communication.game.JoinLobbyResponse> getJoinLobbyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinLobby",
      requestType = code.controller.communication.game.JoinLobbyRequest.class,
      responseType = code.controller.communication.game.JoinLobbyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<code.controller.communication.game.JoinLobbyRequest,
      code.controller.communication.game.JoinLobbyResponse> getJoinLobbyMethod() {
    io.grpc.MethodDescriptor<code.controller.communication.game.JoinLobbyRequest, code.controller.communication.game.JoinLobbyResponse> getJoinLobbyMethod;
    if ((getJoinLobbyMethod = GameGrpc.getJoinLobbyMethod) == null) {
      synchronized (GameGrpc.class) {
        if ((getJoinLobbyMethod = GameGrpc.getJoinLobbyMethod) == null) {
          GameGrpc.getJoinLobbyMethod = getJoinLobbyMethod =
              io.grpc.MethodDescriptor.<code.controller.communication.game.JoinLobbyRequest, code.controller.communication.game.JoinLobbyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinLobby"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.JoinLobbyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.JoinLobbyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameMethodDescriptorSupplier("JoinLobby"))
              .build();
        }
      }
    }
    return getJoinLobbyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<code.controller.communication.game.PollRequest,
      code.controller.communication.game.ResponseStream> getPollGameDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PollGameData",
      requestType = code.controller.communication.game.PollRequest.class,
      responseType = code.controller.communication.game.ResponseStream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<code.controller.communication.game.PollRequest,
      code.controller.communication.game.ResponseStream> getPollGameDataMethod() {
    io.grpc.MethodDescriptor<code.controller.communication.game.PollRequest, code.controller.communication.game.ResponseStream> getPollGameDataMethod;
    if ((getPollGameDataMethod = GameGrpc.getPollGameDataMethod) == null) {
      synchronized (GameGrpc.class) {
        if ((getPollGameDataMethod = GameGrpc.getPollGameDataMethod) == null) {
          GameGrpc.getPollGameDataMethod = getPollGameDataMethod =
              io.grpc.MethodDescriptor.<code.controller.communication.game.PollRequest, code.controller.communication.game.ResponseStream>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PollGameData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.PollRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.ResponseStream.getDefaultInstance()))
              .setSchemaDescriptor(new GameMethodDescriptorSupplier("PollGameData"))
              .build();
        }
      }
    }
    return getPollGameDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<code.controller.communication.game.StartRequest,
      code.controller.communication.game.Void> getStartGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartGame",
      requestType = code.controller.communication.game.StartRequest.class,
      responseType = code.controller.communication.game.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<code.controller.communication.game.StartRequest,
      code.controller.communication.game.Void> getStartGameMethod() {
    io.grpc.MethodDescriptor<code.controller.communication.game.StartRequest, code.controller.communication.game.Void> getStartGameMethod;
    if ((getStartGameMethod = GameGrpc.getStartGameMethod) == null) {
      synchronized (GameGrpc.class) {
        if ((getStartGameMethod = GameGrpc.getStartGameMethod) == null) {
          GameGrpc.getStartGameMethod = getStartGameMethod =
              io.grpc.MethodDescriptor.<code.controller.communication.game.StartRequest, code.controller.communication.game.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.StartRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.Void.getDefaultInstance()))
              .setSchemaDescriptor(new GameMethodDescriptorSupplier("StartGame"))
              .build();
        }
      }
    }
    return getStartGameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<code.controller.communication.game.MoveRequest,
      code.controller.communication.game.Void> getMakeMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MakeMove",
      requestType = code.controller.communication.game.MoveRequest.class,
      responseType = code.controller.communication.game.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<code.controller.communication.game.MoveRequest,
      code.controller.communication.game.Void> getMakeMoveMethod() {
    io.grpc.MethodDescriptor<code.controller.communication.game.MoveRequest, code.controller.communication.game.Void> getMakeMoveMethod;
    if ((getMakeMoveMethod = GameGrpc.getMakeMoveMethod) == null) {
      synchronized (GameGrpc.class) {
        if ((getMakeMoveMethod = GameGrpc.getMakeMoveMethod) == null) {
          GameGrpc.getMakeMoveMethod = getMakeMoveMethod =
              io.grpc.MethodDescriptor.<code.controller.communication.game.MoveRequest, code.controller.communication.game.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MakeMove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.MoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.Void.getDefaultInstance()))
              .setSchemaDescriptor(new GameMethodDescriptorSupplier("MakeMove"))
              .build();
        }
      }
    }
    return getMakeMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<code.controller.communication.game.TwitterRequest,
      code.controller.communication.game.TwitterSuccess> getPostTwitterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PostTwitter",
      requestType = code.controller.communication.game.TwitterRequest.class,
      responseType = code.controller.communication.game.TwitterSuccess.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<code.controller.communication.game.TwitterRequest,
      code.controller.communication.game.TwitterSuccess> getPostTwitterMethod() {
    io.grpc.MethodDescriptor<code.controller.communication.game.TwitterRequest, code.controller.communication.game.TwitterSuccess> getPostTwitterMethod;
    if ((getPostTwitterMethod = GameGrpc.getPostTwitterMethod) == null) {
      synchronized (GameGrpc.class) {
        if ((getPostTwitterMethod = GameGrpc.getPostTwitterMethod) == null) {
          GameGrpc.getPostTwitterMethod = getPostTwitterMethod =
              io.grpc.MethodDescriptor.<code.controller.communication.game.TwitterRequest, code.controller.communication.game.TwitterSuccess>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PostTwitter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.TwitterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.game.TwitterSuccess.getDefaultInstance()))
              .setSchemaDescriptor(new GameMethodDescriptorSupplier("PostTwitter"))
              .build();
        }
      }
    }
    return getPostTwitterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameStub>() {
        @java.lang.Override
        public GameStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameStub(channel, callOptions);
        }
      };
    return GameStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameBlockingStub>() {
        @java.lang.Override
        public GameBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameBlockingStub(channel, callOptions);
        }
      };
    return GameBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameFutureStub>() {
        @java.lang.Override
        public GameFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameFutureStub(channel, callOptions);
        }
      };
    return GameFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getLobbies(code.controller.communication.game.Void request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.GetLobbiesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLobbiesMethod(), responseObserver);
    }

    /**
     */
    default void createLobby(code.controller.communication.game.CreateLobbyRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.CreateLobbyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateLobbyMethod(), responseObserver);
    }

    /**
     */
    default void joinLobby(code.controller.communication.game.JoinLobbyRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.JoinLobbyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinLobbyMethod(), responseObserver);
    }

    /**
     */
    default void pollGameData(code.controller.communication.game.PollRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.ResponseStream> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPollGameDataMethod(), responseObserver);
    }

    /**
     */
    default void startGame(code.controller.communication.game.StartRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.Void> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartGameMethod(), responseObserver);
    }

    /**
     */
    default void makeMove(code.controller.communication.game.MoveRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.Void> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMakeMoveMethod(), responseObserver);
    }

    /**
     */
    default void postTwitter(code.controller.communication.game.TwitterRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.TwitterSuccess> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPostTwitterMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Game.
   */
  public static abstract class GameImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GameGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Game.
   */
  public static final class GameStub
      extends io.grpc.stub.AbstractAsyncStub<GameStub> {
    private GameStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameStub(channel, callOptions);
    }

    /**
     */
    public void getLobbies(code.controller.communication.game.Void request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.GetLobbiesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLobbiesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createLobby(code.controller.communication.game.CreateLobbyRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.CreateLobbyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLobbyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void joinLobby(code.controller.communication.game.JoinLobbyRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.JoinLobbyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinLobbyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pollGameData(code.controller.communication.game.PollRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.ResponseStream> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getPollGameDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startGame(code.controller.communication.game.StartRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.Void> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void makeMove(code.controller.communication.game.MoveRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.Void> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void postTwitter(code.controller.communication.game.TwitterRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.game.TwitterSuccess> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPostTwitterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Game.
   */
  public static final class GameBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GameBlockingStub> {
    private GameBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameBlockingStub(channel, callOptions);
    }

    /**
     */
    public code.controller.communication.game.GetLobbiesResponse getLobbies(code.controller.communication.game.Void request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLobbiesMethod(), getCallOptions(), request);
    }

    /**
     */
    public code.controller.communication.game.CreateLobbyResponse createLobby(code.controller.communication.game.CreateLobbyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLobbyMethod(), getCallOptions(), request);
    }

    /**
     */
    public code.controller.communication.game.JoinLobbyResponse joinLobby(code.controller.communication.game.JoinLobbyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinLobbyMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<code.controller.communication.game.ResponseStream> pollGameData(
        code.controller.communication.game.PollRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getPollGameDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public code.controller.communication.game.Void startGame(code.controller.communication.game.StartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartGameMethod(), getCallOptions(), request);
    }

    /**
     */
    public code.controller.communication.game.Void makeMove(code.controller.communication.game.MoveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMakeMoveMethod(), getCallOptions(), request);
    }

    /**
     */
    public code.controller.communication.game.TwitterSuccess postTwitter(code.controller.communication.game.TwitterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPostTwitterMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Game.
   */
  public static final class GameFutureStub
      extends io.grpc.stub.AbstractFutureStub<GameFutureStub> {
    private GameFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<code.controller.communication.game.GetLobbiesResponse> getLobbies(
        code.controller.communication.game.Void request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLobbiesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<code.controller.communication.game.CreateLobbyResponse> createLobby(
        code.controller.communication.game.CreateLobbyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLobbyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<code.controller.communication.game.JoinLobbyResponse> joinLobby(
        code.controller.communication.game.JoinLobbyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinLobbyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<code.controller.communication.game.Void> startGame(
        code.controller.communication.game.StartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<code.controller.communication.game.Void> makeMove(
        code.controller.communication.game.MoveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<code.controller.communication.game.TwitterSuccess> postTwitter(
        code.controller.communication.game.TwitterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPostTwitterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LOBBIES = 0;
  private static final int METHODID_CREATE_LOBBY = 1;
  private static final int METHODID_JOIN_LOBBY = 2;
  private static final int METHODID_POLL_GAME_DATA = 3;
  private static final int METHODID_START_GAME = 4;
  private static final int METHODID_MAKE_MOVE = 5;
  private static final int METHODID_POST_TWITTER = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LOBBIES:
          serviceImpl.getLobbies((code.controller.communication.game.Void) request,
              (io.grpc.stub.StreamObserver<code.controller.communication.game.GetLobbiesResponse>) responseObserver);
          break;
        case METHODID_CREATE_LOBBY:
          serviceImpl.createLobby((code.controller.communication.game.CreateLobbyRequest) request,
              (io.grpc.stub.StreamObserver<code.controller.communication.game.CreateLobbyResponse>) responseObserver);
          break;
        case METHODID_JOIN_LOBBY:
          serviceImpl.joinLobby((code.controller.communication.game.JoinLobbyRequest) request,
              (io.grpc.stub.StreamObserver<code.controller.communication.game.JoinLobbyResponse>) responseObserver);
          break;
        case METHODID_POLL_GAME_DATA:
          serviceImpl.pollGameData((code.controller.communication.game.PollRequest) request,
              (io.grpc.stub.StreamObserver<code.controller.communication.game.ResponseStream>) responseObserver);
          break;
        case METHODID_START_GAME:
          serviceImpl.startGame((code.controller.communication.game.StartRequest) request,
              (io.grpc.stub.StreamObserver<code.controller.communication.game.Void>) responseObserver);
          break;
        case METHODID_MAKE_MOVE:
          serviceImpl.makeMove((code.controller.communication.game.MoveRequest) request,
              (io.grpc.stub.StreamObserver<code.controller.communication.game.Void>) responseObserver);
          break;
        case METHODID_POST_TWITTER:
          serviceImpl.postTwitter((code.controller.communication.game.TwitterRequest) request,
              (io.grpc.stub.StreamObserver<code.controller.communication.game.TwitterSuccess>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetLobbiesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              code.controller.communication.game.Void,
              code.controller.communication.game.GetLobbiesResponse>(
                service, METHODID_GET_LOBBIES)))
        .addMethod(
          getCreateLobbyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              code.controller.communication.game.CreateLobbyRequest,
              code.controller.communication.game.CreateLobbyResponse>(
                service, METHODID_CREATE_LOBBY)))
        .addMethod(
          getJoinLobbyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              code.controller.communication.game.JoinLobbyRequest,
              code.controller.communication.game.JoinLobbyResponse>(
                service, METHODID_JOIN_LOBBY)))
        .addMethod(
          getPollGameDataMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              code.controller.communication.game.PollRequest,
              code.controller.communication.game.ResponseStream>(
                service, METHODID_POLL_GAME_DATA)))
        .addMethod(
          getStartGameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              code.controller.communication.game.StartRequest,
              code.controller.communication.game.Void>(
                service, METHODID_START_GAME)))
        .addMethod(
          getMakeMoveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              code.controller.communication.game.MoveRequest,
              code.controller.communication.game.Void>(
                service, METHODID_MAKE_MOVE)))
        .addMethod(
          getPostTwitterMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              code.controller.communication.game.TwitterRequest,
              code.controller.communication.game.TwitterSuccess>(
                service, METHODID_POST_TWITTER)))
        .build();
  }

  private static abstract class GameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return code.controller.communication.game.GameOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Game");
    }
  }

  private static final class GameFileDescriptorSupplier
      extends GameBaseDescriptorSupplier {
    GameFileDescriptorSupplier() {}
  }

  private static final class GameMethodDescriptorSupplier
      extends GameBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GameMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GameGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameFileDescriptorSupplier())
              .addMethod(getGetLobbiesMethod())
              .addMethod(getCreateLobbyMethod())
              .addMethod(getJoinLobbyMethod())
              .addMethod(getPollGameDataMethod())
              .addMethod(getStartGameMethod())
              .addMethod(getMakeMoveMethod())
              .addMethod(getPostTwitterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
