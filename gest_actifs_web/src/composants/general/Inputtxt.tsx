import React from 'react'

type inputParam = {
    label: string;
    type: string;
    name: string;
    maxlength?: number;
    required?: boolean;
}

export default function Inputtxt({label, type, name, maxlength, required=false}:inputParam) {
  return (
    <div>
        <label htmlFor={name}>{label}</label>
        <input
            type={type}
            id = {name}
            name = {name}
            required = {required}
            maxLength={maxlength}
        />
    </div>
  )
}
