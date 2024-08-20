package com.joango.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: ExternalService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ExternalServiceCommandsGrpc {

  private ExternalServiceCommandsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.joango.services.ExternalServiceCommands";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.joango.services.CreatePersonCommand,
      com.joango.services.CreatePersonResponse> getCreatePersonMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePerson",
      requestType = com.joango.services.CreatePersonCommand.class,
      responseType = com.joango.services.CreatePersonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.joango.services.CreatePersonCommand,
      com.joango.services.CreatePersonResponse> getCreatePersonMethod() {
    io.grpc.MethodDescriptor<com.joango.services.CreatePersonCommand, com.joango.services.CreatePersonResponse> getCreatePersonMethod;
    if ((getCreatePersonMethod = ExternalServiceCommandsGrpc.getCreatePersonMethod) == null) {
      synchronized (ExternalServiceCommandsGrpc.class) {
        if ((getCreatePersonMethod = ExternalServiceCommandsGrpc.getCreatePersonMethod) == null) {
          ExternalServiceCommandsGrpc.getCreatePersonMethod = getCreatePersonMethod =
              io.grpc.MethodDescriptor.<com.joango.services.CreatePersonCommand, com.joango.services.CreatePersonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePerson"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joango.services.CreatePersonCommand.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joango.services.CreatePersonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExternalServiceCommandsMethodDescriptorSupplier("CreatePerson"))
              .build();
        }
      }
    }
    return getCreatePersonMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.joango.services.CreateAddressBookCommand,
      com.joango.services.CreateAddressBookResponse> getCreateAddressBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAddressBook",
      requestType = com.joango.services.CreateAddressBookCommand.class,
      responseType = com.joango.services.CreateAddressBookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.joango.services.CreateAddressBookCommand,
      com.joango.services.CreateAddressBookResponse> getCreateAddressBookMethod() {
    io.grpc.MethodDescriptor<com.joango.services.CreateAddressBookCommand, com.joango.services.CreateAddressBookResponse> getCreateAddressBookMethod;
    if ((getCreateAddressBookMethod = ExternalServiceCommandsGrpc.getCreateAddressBookMethod) == null) {
      synchronized (ExternalServiceCommandsGrpc.class) {
        if ((getCreateAddressBookMethod = ExternalServiceCommandsGrpc.getCreateAddressBookMethod) == null) {
          ExternalServiceCommandsGrpc.getCreateAddressBookMethod = getCreateAddressBookMethod =
              io.grpc.MethodDescriptor.<com.joango.services.CreateAddressBookCommand, com.joango.services.CreateAddressBookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAddressBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joango.services.CreateAddressBookCommand.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joango.services.CreateAddressBookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExternalServiceCommandsMethodDescriptorSupplier("CreateAddressBook"))
              .build();
        }
      }
    }
    return getCreateAddressBookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.joango.services.EntityId,
      com.joango.services.GetPersonResponse> getGetPersonByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPersonById",
      requestType = com.joango.services.EntityId.class,
      responseType = com.joango.services.GetPersonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.joango.services.EntityId,
      com.joango.services.GetPersonResponse> getGetPersonByIdMethod() {
    io.grpc.MethodDescriptor<com.joango.services.EntityId, com.joango.services.GetPersonResponse> getGetPersonByIdMethod;
    if ((getGetPersonByIdMethod = ExternalServiceCommandsGrpc.getGetPersonByIdMethod) == null) {
      synchronized (ExternalServiceCommandsGrpc.class) {
        if ((getGetPersonByIdMethod = ExternalServiceCommandsGrpc.getGetPersonByIdMethod) == null) {
          ExternalServiceCommandsGrpc.getGetPersonByIdMethod = getGetPersonByIdMethod =
              io.grpc.MethodDescriptor.<com.joango.services.EntityId, com.joango.services.GetPersonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPersonById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joango.services.EntityId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joango.services.GetPersonResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExternalServiceCommandsMethodDescriptorSupplier("GetPersonById"))
              .build();
        }
      }
    }
    return getGetPersonByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExternalServiceCommandsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExternalServiceCommandsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExternalServiceCommandsStub>() {
        @java.lang.Override
        public ExternalServiceCommandsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExternalServiceCommandsStub(channel, callOptions);
        }
      };
    return ExternalServiceCommandsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExternalServiceCommandsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExternalServiceCommandsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExternalServiceCommandsBlockingStub>() {
        @java.lang.Override
        public ExternalServiceCommandsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExternalServiceCommandsBlockingStub(channel, callOptions);
        }
      };
    return ExternalServiceCommandsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExternalServiceCommandsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExternalServiceCommandsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExternalServiceCommandsFutureStub>() {
        @java.lang.Override
        public ExternalServiceCommandsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExternalServiceCommandsFutureStub(channel, callOptions);
        }
      };
    return ExternalServiceCommandsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createPerson(com.joango.services.CreatePersonCommand request,
        io.grpc.stub.StreamObserver<com.joango.services.CreatePersonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePersonMethod(), responseObserver);
    }

    /**
     */
    default void createAddressBook(com.joango.services.CreateAddressBookCommand request,
        io.grpc.stub.StreamObserver<com.joango.services.CreateAddressBookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAddressBookMethod(), responseObserver);
    }

    /**
     */
    default void getPersonById(com.joango.services.EntityId request,
        io.grpc.stub.StreamObserver<com.joango.services.GetPersonResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPersonByIdMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ExternalServiceCommands.
   */
  public static abstract class ExternalServiceCommandsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ExternalServiceCommandsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ExternalServiceCommands.
   */
  public static final class ExternalServiceCommandsStub
      extends io.grpc.stub.AbstractAsyncStub<ExternalServiceCommandsStub> {
    private ExternalServiceCommandsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExternalServiceCommandsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExternalServiceCommandsStub(channel, callOptions);
    }

    /**
     */
    public void createPerson(com.joango.services.CreatePersonCommand request,
        io.grpc.stub.StreamObserver<com.joango.services.CreatePersonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePersonMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createAddressBook(com.joango.services.CreateAddressBookCommand request,
        io.grpc.stub.StreamObserver<com.joango.services.CreateAddressBookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAddressBookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPersonById(com.joango.services.EntityId request,
        io.grpc.stub.StreamObserver<com.joango.services.GetPersonResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPersonByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ExternalServiceCommands.
   */
  public static final class ExternalServiceCommandsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ExternalServiceCommandsBlockingStub> {
    private ExternalServiceCommandsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExternalServiceCommandsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExternalServiceCommandsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.joango.services.CreatePersonResponse createPerson(com.joango.services.CreatePersonCommand request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePersonMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.joango.services.CreateAddressBookResponse createAddressBook(com.joango.services.CreateAddressBookCommand request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAddressBookMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.joango.services.GetPersonResponse getPersonById(com.joango.services.EntityId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPersonByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ExternalServiceCommands.
   */
  public static final class ExternalServiceCommandsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ExternalServiceCommandsFutureStub> {
    private ExternalServiceCommandsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExternalServiceCommandsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExternalServiceCommandsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.joango.services.CreatePersonResponse> createPerson(
        com.joango.services.CreatePersonCommand request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePersonMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.joango.services.CreateAddressBookResponse> createAddressBook(
        com.joango.services.CreateAddressBookCommand request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAddressBookMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.joango.services.GetPersonResponse> getPersonById(
        com.joango.services.EntityId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPersonByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PERSON = 0;
  private static final int METHODID_CREATE_ADDRESS_BOOK = 1;
  private static final int METHODID_GET_PERSON_BY_ID = 2;

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
        case METHODID_CREATE_PERSON:
          serviceImpl.createPerson((com.joango.services.CreatePersonCommand) request,
              (io.grpc.stub.StreamObserver<com.joango.services.CreatePersonResponse>) responseObserver);
          break;
        case METHODID_CREATE_ADDRESS_BOOK:
          serviceImpl.createAddressBook((com.joango.services.CreateAddressBookCommand) request,
              (io.grpc.stub.StreamObserver<com.joango.services.CreateAddressBookResponse>) responseObserver);
          break;
        case METHODID_GET_PERSON_BY_ID:
          serviceImpl.getPersonById((com.joango.services.EntityId) request,
              (io.grpc.stub.StreamObserver<com.joango.services.GetPersonResponse>) responseObserver);
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
          getCreatePersonMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.joango.services.CreatePersonCommand,
              com.joango.services.CreatePersonResponse>(
                service, METHODID_CREATE_PERSON)))
        .addMethod(
          getCreateAddressBookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.joango.services.CreateAddressBookCommand,
              com.joango.services.CreateAddressBookResponse>(
                service, METHODID_CREATE_ADDRESS_BOOK)))
        .addMethod(
          getGetPersonByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.joango.services.EntityId,
              com.joango.services.GetPersonResponse>(
                service, METHODID_GET_PERSON_BY_ID)))
        .build();
  }

  private static abstract class ExternalServiceCommandsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExternalServiceCommandsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.joango.services.ExternalService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExternalServiceCommands");
    }
  }

  private static final class ExternalServiceCommandsFileDescriptorSupplier
      extends ExternalServiceCommandsBaseDescriptorSupplier {
    ExternalServiceCommandsFileDescriptorSupplier() {}
  }

  private static final class ExternalServiceCommandsMethodDescriptorSupplier
      extends ExternalServiceCommandsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ExternalServiceCommandsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ExternalServiceCommandsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExternalServiceCommandsFileDescriptorSupplier())
              .addMethod(getCreatePersonMethod())
              .addMethod(getCreateAddressBookMethod())
              .addMethod(getGetPersonByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
