package com.joango.services

import com.joango.services.ExternalServiceCommandsGrpc.getServiceDescriptor
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Holder for Kotlin coroutine-based client and server APIs for
 * com.joango.services.ExternalServiceCommands.
 */
public object ExternalServiceCommandsGrpcKt {
  public const val SERVICE_NAME: String = ExternalServiceCommandsGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = getServiceDescriptor()

  public val createPersonMethod: MethodDescriptor<CreatePersonCommand, CreatePersonResponse>
    @JvmStatic
    get() = ExternalServiceCommandsGrpc.getCreatePersonMethod()

  public val createAddressBookMethod:
      MethodDescriptor<CreateAddressBookCommand, CreateAddressBookResponse>
    @JvmStatic
    get() = ExternalServiceCommandsGrpc.getCreateAddressBookMethod()

  public val getPersonByIdMethod: MethodDescriptor<EntityId, GetPersonResponse>
    @JvmStatic
    get() = ExternalServiceCommandsGrpc.getGetPersonByIdMethod()

  /**
   * A stub for issuing RPCs to a(n) com.joango.services.ExternalServiceCommands service as
   * suspending coroutines.
   */
  @StubFor(ExternalServiceCommandsGrpc::class)
  public class ExternalServiceCommandsCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<ExternalServiceCommandsCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions):
        ExternalServiceCommandsCoroutineStub = ExternalServiceCommandsCoroutineStub(channel,
        callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun createPerson(request: CreatePersonCommand, headers: Metadata = Metadata()):
        CreatePersonResponse = unaryRpc(
      channel,
      ExternalServiceCommandsGrpc.getCreatePersonMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun createAddressBook(request: CreateAddressBookCommand, headers: Metadata =
        Metadata()): CreateAddressBookResponse = unaryRpc(
      channel,
      ExternalServiceCommandsGrpc.getCreateAddressBookMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getPersonById(request: EntityId, headers: Metadata = Metadata()):
        GetPersonResponse = unaryRpc(
      channel,
      ExternalServiceCommandsGrpc.getGetPersonByIdMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the com.joango.services.ExternalServiceCommands service based on
   * Kotlin coroutines.
   */
  public abstract class ExternalServiceCommandsCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for com.joango.services.ExternalServiceCommands.CreatePerson.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun createPerson(request: CreatePersonCommand): CreatePersonResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.joango.services.ExternalServiceCommands.CreatePerson is unimplemented"))

    /**
     * Returns the response to an RPC for
     * com.joango.services.ExternalServiceCommands.CreateAddressBook.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun createAddressBook(request: CreateAddressBookCommand):
        CreateAddressBookResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.joango.services.ExternalServiceCommands.CreateAddressBook is unimplemented"))

    /**
     * Returns the response to an RPC for com.joango.services.ExternalServiceCommands.GetPersonById.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getPersonById(request: EntityId): GetPersonResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method com.joango.services.ExternalServiceCommands.GetPersonById is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ExternalServiceCommandsGrpc.getCreatePersonMethod(),
      implementation = ::createPerson
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ExternalServiceCommandsGrpc.getCreateAddressBookMethod(),
      implementation = ::createAddressBook
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = ExternalServiceCommandsGrpc.getGetPersonByIdMethod(),
      implementation = ::getPersonById
    )).build()
  }
}
