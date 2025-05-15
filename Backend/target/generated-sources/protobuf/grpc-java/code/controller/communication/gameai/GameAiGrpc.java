package code.controller.communication.gameai;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.61.0)",
    comments = "Source: GameAI.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GameAiGrpc {

  private GameAiGrpc() {}

  public static final java.lang.String SERVICE_NAME = "GameAi";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<code.controller.communication.gameai.BoardStateRequest,
      code.controller.communication.gameai.ColumnReply> getGiveBestMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GiveBestMove",
      requestType = code.controller.communication.gameai.BoardStateRequest.class,
      responseType = code.controller.communication.gameai.ColumnReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<code.controller.communication.gameai.BoardStateRequest,
      code.controller.communication.gameai.ColumnReply> getGiveBestMoveMethod() {
    io.grpc.MethodDescriptor<code.controller.communication.gameai.BoardStateRequest, code.controller.communication.gameai.ColumnReply> getGiveBestMoveMethod;
    if ((getGiveBestMoveMethod = GameAiGrpc.getGiveBestMoveMethod) == null) {
      synchronized (GameAiGrpc.class) {
        if ((getGiveBestMoveMethod = GameAiGrpc.getGiveBestMoveMethod) == null) {
          GameAiGrpc.getGiveBestMoveMethod = getGiveBestMoveMethod =
              io.grpc.MethodDescriptor.<code.controller.communication.gameai.BoardStateRequest, code.controller.communication.gameai.ColumnReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GiveBestMove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.gameai.BoardStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  code.controller.communication.gameai.ColumnReply.getDefaultInstance()))
              .setSchemaDescriptor(new GameAiMethodDescriptorSupplier("GiveBestMove"))
              .build();
        }
      }
    }
    return getGiveBestMoveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameAiStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameAiStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameAiStub>() {
        @java.lang.Override
        public GameAiStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameAiStub(channel, callOptions);
        }
      };
    return GameAiStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameAiBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameAiBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameAiBlockingStub>() {
        @java.lang.Override
        public GameAiBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameAiBlockingStub(channel, callOptions);
        }
      };
    return GameAiBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameAiFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameAiFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameAiFutureStub>() {
        @java.lang.Override
        public GameAiFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameAiFutureStub(channel, callOptions);
        }
      };
    return GameAiFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void giveBestMove(code.controller.communication.gameai.BoardStateRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.gameai.ColumnReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGiveBestMoveMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GameAi.
   */
  public static abstract class GameAiImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GameAiGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GameAi.
   */
  public static final class GameAiStub
      extends io.grpc.stub.AbstractAsyncStub<GameAiStub> {
    private GameAiStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameAiStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameAiStub(channel, callOptions);
    }

    /**
     */
    public void giveBestMove(code.controller.communication.gameai.BoardStateRequest request,
        io.grpc.stub.StreamObserver<code.controller.communication.gameai.ColumnReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGiveBestMoveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GameAi.
   */
  public static final class GameAiBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GameAiBlockingStub> {
    private GameAiBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameAiBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameAiBlockingStub(channel, callOptions);
    }

    /**
     */
    public code.controller.communication.gameai.ColumnReply giveBestMove(code.controller.communication.gameai.BoardStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGiveBestMoveMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GameAi.
   */
  public static final class GameAiFutureStub
      extends io.grpc.stub.AbstractFutureStub<GameAiFutureStub> {
    private GameAiFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameAiFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameAiFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<code.controller.communication.gameai.ColumnReply> giveBestMove(
        code.controller.communication.gameai.BoardStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGiveBestMoveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GIVE_BEST_MOVE = 0;

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
        case METHODID_GIVE_BEST_MOVE:
          serviceImpl.giveBestMove((code.controller.communication.gameai.BoardStateRequest) request,
              (io.grpc.stub.StreamObserver<code.controller.communication.gameai.ColumnReply>) responseObserver);
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
          getGiveBestMoveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              code.controller.communication.gameai.BoardStateRequest,
              code.controller.communication.gameai.ColumnReply>(
                service, METHODID_GIVE_BEST_MOVE)))
        .build();
  }

  private static abstract class GameAiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameAiBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return code.controller.communication.gameai.GameAI.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameAi");
    }
  }

  private static final class GameAiFileDescriptorSupplier
      extends GameAiBaseDescriptorSupplier {
    GameAiFileDescriptorSupplier() {}
  }

  private static final class GameAiMethodDescriptorSupplier
      extends GameAiBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GameAiMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GameAiGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameAiFileDescriptorSupplier())
              .addMethod(getGiveBestMoveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
