package com.joango.services;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: MainService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MainServiceCommandsGrpc {

  private MainServiceCommandsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.joango.services.MainServiceCommands";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.joango.services.ProcessAddressBookCommand,
      com.joango.services.ProcessAddressBookResponse> getProcessAddressBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessAddressBook",
      requestType = com.joango.services.ProcessAddressBookCommand.class,
      responseType = com.joango.services.ProcessAddressBookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.joango.services.ProcessAddressBookCommand,
      com.joango.services.ProcessAddressBookResponse> getProcessAddressBookMethod() {
    io.grpc.MethodDescriptor<com.joango.services.ProcessAddressBookCommand, com.joango.services.ProcessAddressBookResponse> getProcessAddressBookMethod;
    if ((getProcessAddressBookMethod = MainServiceCommandsGrpc.getProcessAddressBookMethod) == null) {
      synchronized (MainServiceCommandsGrpc.class) {
        if ((getProcessAddressBookMethod = MainServiceCommandsGrpc.getProcessAddressBookMethod) == null) {
          MainServiceCommandsGrpc.getProcessAddressBookMethod = getProcessAddressBookMethod =
              io.grpc.MethodDescriptor.<com.joango.services.ProcessAddressBookCommand, com.joango.services.ProcessAddressBookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessAddressBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joango.services.ProcessAddressBookCommand.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joango.services.ProcessAddressBookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MainServiceCommandsMethodDescriptorSupplier("ProcessAddressBook"))
              .build();
        }
      }
    }
    return getProcessAddressBookMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MainServiceCommandsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MainServiceCommandsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MainServiceCommandsStub>() {
        @java.lang.Override
        public MainServiceCommandsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MainServiceCommandsStub(channel, callOptions);
        }
      };
    return MainServiceCommandsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MainServiceCommandsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MainServiceCommandsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MainServiceCommandsBlockingStub>() {
        @java.lang.Override
        public MainServiceCommandsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MainServiceCommandsBlockingStub(channel, callOptions);
        }
      };
    return MainServiceCommandsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MainServiceCommandsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MainServiceCommandsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MainServiceCommandsFutureStub>() {
        @java.lang.Override
        public MainServiceCommandsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MainServiceCommandsFutureStub(channel, callOptions);
        }
      };
    return MainServiceCommandsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void processAddressBook(com.joango.services.ProcessAddressBookCommand request,
        io.grpc.stub.StreamObserver<com.joango.services.ProcessAddressBookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessAddressBookMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MainServiceCommands.
   */
  public static abstract class MainServiceCommandsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MainServiceCommandsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MainServiceCommands.
   */
  public static final class MainServiceCommandsStub
      extends io.grpc.stub.AbstractAsyncStub<MainServiceCommandsStub> {
    private MainServiceCommandsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MainServiceCommandsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MainServiceCommandsStub(channel, callOptions);
    }

    /**
     */
    public void processAddressBook(com.joango.services.ProcessAddressBookCommand request,
        io.grpc.stub.StreamObserver<com.joango.services.ProcessAddressBookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessAddressBookMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MainServiceCommands.
   */
  public static final class MainServiceCommandsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MainServiceCommandsBlockingStub> {
    private MainServiceCommandsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MainServiceCommandsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MainServiceCommandsBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.joango.services.ProcessAddressBookResponse processAddressBook(com.joango.services.ProcessAddressBookCommand request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessAddressBookMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MainServiceCommands.
   */
  public static final class MainServiceCommandsFutureStub
      extends io.grpc.stub.AbstractFutureStub<MainServiceCommandsFutureStub> {
    private MainServiceCommandsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MainServiceCommandsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MainServiceCommandsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.joango.services.ProcessAddressBookResponse> processAddressBook(
        com.joango.services.ProcessAddressBookCommand request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessAddressBookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_ADDRESS_BOOK = 0;

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
        case METHODID_PROCESS_ADDRESS_BOOK:
          serviceImpl.processAddressBook((com.joango.services.ProcessAddressBookCommand) request,
              (io.grpc.stub.StreamObserver<com.joango.services.ProcessAddressBookResponse>) responseObserver);
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
          getProcessAddressBookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.joango.services.ProcessAddressBookCommand,
              com.joango.services.ProcessAddressBookResponse>(
                service, METHODID_PROCESS_ADDRESS_BOOK)))
        .build();
  }

  private static abstract class MainServiceCommandsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MainServiceCommandsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.joango.services.MainService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MainServiceCommands");
    }
  }

  private static final class MainServiceCommandsFileDescriptorSupplier
      extends MainServiceCommandsBaseDescriptorSupplier {
    MainServiceCommandsFileDescriptorSupplier() {}
  }

  private static final class MainServiceCommandsMethodDescriptorSupplier
      extends MainServiceCommandsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MainServiceCommandsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MainServiceCommandsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MainServiceCommandsFileDescriptorSupplier())
              .addMethod(getProcessAddressBookMethod())
              .build();
        }
      }
    }
    return result;
  }
}
