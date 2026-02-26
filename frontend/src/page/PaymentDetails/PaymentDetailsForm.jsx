import React from 'react'
import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form"
import { useForm } from 'react-hook-form'
import { Input } from '@/components/ui/input'
import { Button } from '@/components/ui/button'
import { DialogClose } from '@/components/ui/dialog'
import { useDispatch } from 'react-redux'
import { addPaymentDetails } from '@/State/Withdrawal/Action'

const PaymentDetailsForm = () => {
    const dispatch=useDispatch();
    const form = useForm({
        resolver: "",
        defaultValues: {
            accountHolderName: "",
            ifsc: "",
            accountNumber: "",
            bankName: ""
        }
    })
    const onSubmit = (data) => {
        dispatch(addPaymentDetails({
            paymentDetails:data,
            jwt:localStorage.getItem("jwt")
        }))
        console.log(data)
    }
    return (
        <div className='px-10 py-2'>
            <Form {...form}>
                <form
                    onSubmit={form.handleSubmit(onSubmit)}
                    className='space-y-6'>

                    <FormField
                        control={form.control}
                        name="accountHolderName"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Account Holder Name</FormLabel>
                                <FormControl>
                                    <Input

                                        className="border w-full border-gray-800 p-5"
                                        placeholder="Trade With Bitvera"{...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>

                        )}
                    />

                    <FormField
                        control={form.control}
                        name="ifsc"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>IFSC Code</FormLabel>
                                <FormControl>
                                    <Input

                                        className="border w-full border-gray-800 p-5"
                                        placeholder="BIT00001"{...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>

                        )}
                    />

                    <FormField
                        control={form.control}
                        name="accountNumber"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Account Number</FormLabel>
                                <FormControl>
                                    <Input
                                        className="border w-full border-gray-800 p-5"
                                        placeholder="XXXX XXXX 1234"{...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>

                        )}
                    />

                    <FormField
                        control={form.control}
                        name="confrimAccountNumber"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Confrim Account Number</FormLabel>
                                <FormControl>
                                    <Input
                                        className="border w-full border-gray-800 p-5"
                                        placeholder="XXXX XXXX 1234"{...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>

                        )}
                    />


                    <FormField
                        control={form.control}
                        name="bankName"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Bank Name</FormLabel>
                                <FormControl>
                                    <Input
                                        className="border w-full border-gray-800 p-5"
                                        placeholder="Bitvera Bank"{...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>

                        )}
                    />
                    <DialogClose className='w-full'>
                        <Button type="submit" className="w-full py-5">
                            Submit
                        </Button>
                    </DialogClose>
                </form>

            </Form>
        </div>
    )
}

export default PaymentDetailsForm