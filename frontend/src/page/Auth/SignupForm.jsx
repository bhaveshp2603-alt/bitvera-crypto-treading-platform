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
import { register } from '@/State/Auth/Action'

const SignupForm = () => {

    const dispatch=useDispatch()
    const form = useForm({
        resolver: "",
        defaultValues: {
            fullName: "",
            email: "",
            password: "",
            
        }
    })
    const onSubmit = (data) => {
        dispatch(register(data))
        console.log(data)
    }
    return (
        <div>
          <h1 className='text-xl font-bold text-center pb-3'>Create New Account</h1>
            <Form {...form}>
                <form
                    onSubmit={form.handleSubmit(onSubmit)}
                    className='space-y-6'>

                    <FormField
                        control={form.control}
                        name="fullName"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Enter Full Name</FormLabel>
                                <FormControl>
                                    <Input

                                        className="border w-full border-gray-800 p-5"
                                        placeholder="Bitvera"{...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>

                        )}
                    />

                    <FormField
                        control={form.control}
                        name="email"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Enter Email</FormLabel>
                                <FormControl>
                                    <Input

                                        className="border w-full border-gray-800 p-5"
                                        placeholder="bitvera@gmail.com"{...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>

                        )}
                    />

                    <FormField
                        control={form.control}
                        name="password"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Create Password</FormLabel>
                                <FormControl>
                                    <Input
                                        className="border w-full border-gray-800 p-5"
                                        placeholder="XXXXXXXX1234"{...field} />
                                </FormControl>
                                <FormMessage />
                            </FormItem>

                        )}
                    />
                        <Button type="submit" className="w-full py-5">
                            Submit
                        </Button>
                  
                </form>

            </Form>
        </div>
    )
}

export default SignupForm